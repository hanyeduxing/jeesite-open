/*	
 * Decompiled with CFR 0.140.	
 */	
package com.jeesite.modules.sys.service;	
	
import com.jeesite.common.entity.DataEntity;	
import com.jeesite.common.entity.Page;	
import com.jeesite.common.service.api.CrudServiceApi;	
import com.jeesite.modules.sys.entity.Lang;	
	
public interface LangService	
extends CrudServiceApi<Lang> {	
    @Override	
    public Lang get(Lang var1);	
	
    @Override	
    public void save(Lang var1);	
	
    @Override	
    public void delete(Lang var1);	
	
    public void clearCache();	
	
    @Override	
    public Page<Lang> findPage(Lang var1);	
}	
	
