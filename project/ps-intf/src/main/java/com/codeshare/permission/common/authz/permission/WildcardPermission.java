package com.codeshare.permission.common.authz.permission;

import com.codeshare.permission.common.authz.Permission;
import com.codeshare.permission.common.util.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * @author cjbi
 */
public class WildcardPermission implements Permission, Serializable {

    protected static final String WILDCARD_TOKEN = "*";
    protected static final String PART_DIVIDER_TOKEN = ":";
    protected static final String SUBPART_DIVIDER_TOKEN = ",";
    protected static final boolean DEFAULT_CASE_SENSITIVE = false;

    private List<Set<String>> parts;

    protected WildcardPermission() {
    }

    public WildcardPermission(String wildcardString) {
        this(wildcardString, DEFAULT_CASE_SENSITIVE);
    }

    public WildcardPermission(String wildcardString, boolean caseSensitive) {
        setParts(wildcardString, caseSensitive);
    }

    private int computeListCapacity(int arraySize) {
        return (int) Math.min(5L + arraySize + (arraySize / 10), Integer.MAX_VALUE);
    }

    protected void setParts(String wildcardString) {
        setParts(wildcardString, DEFAULT_CASE_SENSITIVE);
    }

    protected void setParts(String wildcardString, boolean caseSensitive) {
        if (wildcardString == null || wildcardString.trim().length() == 0) {
            throw new IllegalArgumentException("Wildcard string cannot be null or empty. Make sure permission strings are properly formatted.");
        }

        wildcardString = wildcardString.trim();

        List<String> parts = CollectionUtils.asList(wildcardString.split(PART_DIVIDER_TOKEN));

        this.parts = new ArrayList<Set<String>>();
        for (String part : parts) {
            Set<String> subparts = CollectionUtils.asSet(part.split(SUBPART_DIVIDER_TOKEN));
            if (!caseSensitive) {
                subparts = lowercase(subparts);
            }
            if (subparts.isEmpty()) {
                throw new IllegalArgumentException("Wildcard string cannot contain parts with only dividers. Make sure permission strings are properly formatted.");
            }
            this.parts.add(subparts);
        }

        if (this.parts.isEmpty()) {
            throw new IllegalArgumentException("Wildcard string cannot contain only dividers. Make sure permission strings are properly formatted.");
        }
    }

    private Set<String> lowercase(Set<String> subparts) {
        Set<String> lowerCasedSubparts = new LinkedHashSet<String>(subparts.size());
        for (String subpart : subparts) {
            lowerCasedSubparts.add(subpart.toLowerCase());
        }
        return lowerCasedSubparts;
    }

    protected List<Set<String>> getParts() {
        return this.parts;
    }

    @Override
    public boolean implies(Permission p) {
        // By default only supports comparisons with other WildcardPermissions
        if (!(p instanceof WildcardPermission)) {
            return false;
        }

        WildcardPermission wp = (WildcardPermission) p;

        List<Set<String>> otherParts = wp.getParts();

        int i = 0;
        for (Set<String> otherPart : otherParts) {
            // If this permission has less parts than the other permission, everything after the number of parts contained
            // in this permission is automatically implied, so return true
            if (getParts().size() - 1 < i) {
                return true;
            } else {
                Set<String> part = getParts().get(i);
                if (!part.contains(WILDCARD_TOKEN) && !part.containsAll(otherPart)) {
                    return false;
                }
                i++;
            }
        }

        // If this permission has more parts than the other parts, only imply it if all of the other parts are wildcards
        for (; i < getParts().size(); i++) {
            Set<String> part = getParts().get(i);
            if (!part.contains(WILDCARD_TOKEN)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (Set<String> part : parts) {
            if (buffer.length() > 0) {
                buffer.append(":");
            }
            buffer.append(part);
        }
        return buffer.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof WildcardPermission) {
            WildcardPermission wp = (WildcardPermission) o;
            return parts.equals(wp.parts);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return parts.hashCode();
    }

}
