/*	
 * Decompiled with CFR 0.139.	
 * 	
 * Could not load the following classes:	
 *  com.jeesite.common.web.http.ServletUtils	
 *  javax.servlet.ServletRequest	
 *  javax.servlet.http.HttpServletRequest	
 *  org.springframework.boot.autoconfigure.condition.ConditionalOnProperty	
 *  org.springframework.stereotype.Controller	
 *  org.springframework.ui.Model	
 *  org.springframework.web.bind.annotation.RequestMapping	
 */	
package com.jeesite.modules.sys.web;	
	
import com.jeesite.common.web.BaseController;	
import com.jeesite.common.web.http.ServletUtils;	
import java.util.Map;	
import javax.servlet.ServletRequest;	
import javax.servlet.http.HttpServletRequest;	
import org.hyperic.sigar.SysInfo;	
import org.hyperic.sigar.cmd.Tail;	
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;	
import org.springframework.stereotype.Controller;	
import org.springframework.ui.Model;	
import org.springframework.web.bind.annotation.RequestMapping;	
	
@Controller	
@RequestMapping(value={"tags"})	
@ConditionalOnProperty(name={"web.core.enabled"}, havingValue="true", matchIfMissing=true)	
public class TagsController	
extends BaseController {	
    @RequestMapping(value={"treeselect"})	
    public String treeselect(HttpServletRequest request, Model model) {	
        model.addAllAttributes(ServletUtils.getParameters((ServletRequest)request));	
        return "tagsview/form/treeselect";	
    }	
	
    @RequestMapping(value={"iconselect"})	
    public String iconselect(HttpServletRequest request, Model model) {	
        model.addAllAttributes(ServletUtils.getParameters((ServletRequest)request));	
        return "tagsview/form/iconselect";	
    }	
	
    @RequestMapping(value={"imageclip"})	
    public String imageclip(HttpServletRequest request, Model model) {	
        model.addAllAttributes(ServletUtils.getParameters((ServletRequest)request));	
        return "tagsview/form/imageclip";	
    }	
}	
	
