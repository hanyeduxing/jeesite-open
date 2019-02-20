/*	
 * Decompiled with CFR 0.139.	
 */	
package com.jeesite.modules.sys.entity;	
	
import com.jeesite.common.entity.DataEntity;	
import com.jeesite.common.mybatis.annotation.Column;	
import com.jeesite.common.mybatis.annotation.Table;	
	
@Table(name="${_prefix}sys_role_menu", alias="a", columns={@Column(name="role_code", attrName="roleCode", label="\u89d2\u8272\u7f16\u7801", isPK=true), @Column(name="menu_code", attrName="menuCode", label="\u83dc\u5355\u7f16\u7801", isPK=true)}, orderBy="")	
public class RoleMenu	
extends DataEntity<RoleMenu> {	
    private String roleCode;	
    private String menuCode;	
    private static final long serialVersionUID = 1L;	
	
    public RoleMenu() {	
        this(null);	
    }	
	
    public String getRoleCode() {	
        return this.roleCode;	
    }	
	
    public void setRoleCode(String roleCode) {	
        this.roleCode = roleCode;	
    }	
	
    public RoleMenu(String id) {	
        super(id);	
    }	
	
    public void setMenuCode(String menuCode) {	
        this.menuCode = menuCode;	
    }	
	
    public String getMenuCode() {	
        return this.menuCode;	
    }	
}	
	
