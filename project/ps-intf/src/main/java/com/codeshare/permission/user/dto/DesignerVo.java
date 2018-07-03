package com.codeshare.permission.user.dto;

import com.codeshare.permission.user.enums.Source;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel("设计师信息")
public class DesignerVo implements IUser {
	
	@ApiModelProperty("设计师ID")
	private Integer id;

    /**
     *用户ID
     */
	@ApiModelProperty("用户ID")
    private Integer userId;
    
    /**
     * 真实姓名
     */
	@ApiModelProperty("真实姓名")
    private String name;

    /**
     *设计案例
     */
	@ApiModelProperty("设计案例")
    private String designCase;

    /**
     *公司
     */
	@ApiModelProperty("公司")
    private String company;

    /**
     *住所
     */
	@ApiModelProperty("住所")
    private String residency;

    /**
     *补充
     */
	@ApiModelProperty("补充")
    private String extra;

	@ApiModelProperty("更新时间")
    private Date updatetime;

	@ApiModelProperty("新增时间")
    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public Source getSource() {
        return Source.user_center;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignCase() {
        return designCase;
    }

    public void setDesignCase(String designCase) {
        this.designCase = designCase;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getResidency() {
        return residency;
    }

    public void setResidency(String residency) {
        this.residency = residency;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}