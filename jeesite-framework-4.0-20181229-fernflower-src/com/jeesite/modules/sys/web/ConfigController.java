package com.jeesite.modules.sys.web;	
	
import com.jeesite.common.entity.Page;	
import com.jeesite.common.lang.StringUtils;	
import com.jeesite.common.web.BaseController;	
import com.jeesite.modules.config.CoreConfig;	
import com.jeesite.modules.sys.entity.Config;	
import com.jeesite.modules.sys.service.ConfigService;	
import javax.servlet.http.HttpServletRequest;	
import javax.servlet.http.HttpServletResponse;	
import org.apache.shiro.authz.annotation.RequiresPermissions;	
import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Controller;	
import org.springframework.ui.Model;	
import org.springframework.validation.annotation.Validated;	
import org.springframework.web.bind.annotation.ModelAttribute;	
import org.springframework.web.bind.annotation.PostMapping;	
import org.springframework.web.bind.annotation.RequestMapping;	
import org.springframework.web.bind.annotation.ResponseBody;	
	
@Controller	
@RequestMapping({"${adminPath}/sys/config"})	
public class ConfigController extends BaseController {	
   @Autowired	
   private ConfigService configService;	
	
   @RequiresPermissions({"sys:config:edit"})	
   @PostMapping({"save"})	
   @ResponseBody	
   public String save(@Validated Config config, HttpServletRequest request) {	
      Config a;	
      if ((a = (Config)super.getWebDataBinderSource(request)) != null && "1".equals(a.getIsSys()) && !config.getCurrentUser().isSuperAdmin()) {	
         return this.renderResult("false", "越权操作，只有超级管理员才能修改系统数据！");	
      } else {	
         if (!config.getCurrentUser().isSuperAdmin()) {	
            config.setConfigName(a.getConfigName());	
            config.setConfigKey(a.getConfigKey());	
         }	
	
         this.configService.save(config);	
         return this.renderResult("true", ValidCodeController.ALLATORIxDEMO ("俉孳取敛戄労５"));	
      }	
   }	
	
   @RequiresPermissions({"sys:config:view"})	
   @RequestMapping({"list"})	
   public String list(Config config, Model model) {	
      return "modules/sys/configList";	
   }	
	
   @RequiresPermissions({"sys:config:view"})	
   @RequestMapping({"listData"})	
   @ResponseBody	
   public Page listData(Config config, HttpServletRequest request, HttpServletResponse response) {	
      return this.configService.findPage(new Page(request, response), config);	
   }	
	
   @RequiresPermissions({"sys:config:edit"})	
   @RequestMapping({"checkConfigKey"})	
   @ResponseBody	
   public String checkConfigKey(String oldConfigKey, String configKey) {	
      Config a;	
      (a = new Config()).setConfigKey(configKey);	
      if (configKey != null && configKey.equals(oldConfigKey)) {	
         return "true";	
      } else {	
         return configKey != null && this.configService.findCount(a) == 0L ? "true" : "false";	
      }	
   }	
	
   @RequiresPermissions({"sys:config:edit"})	
   @RequestMapping({"delete"})	
   @ResponseBody	
   public String delete(Config config, HttpServletRequest request) {	
      if (StringUtils.isNotBlank(request.getParameter(ValidCodeController.ALLATORIxDEMO ("}XGRg")))) {	
         return this.renderResult("false", "越权操作，isSys非法参数！");	
      } else {	
         Config a;	
         if ((a = (Config)super.getWebDataBinderSource(request)) != null && "1".equals(a.getIsSys()) && !config.getCurrentUser().isSuperAdmin()) {	
            return this.renderResult("false", ValidCodeController.ALLATORIxDEMO ("趞杨擙佷８叁朝趮纳箊琒味扙胖俺攒糯维敤捅５"));	
         } else {	
            this.configService.delete(config);	
            return this.renderResult("true", "删除参数成功！");	
         }	
      }	
   }	
	
   @ModelAttribute	
   public Config get(String id, boolean isNewRecord) {	
      return (Config)this.configService.get(id, isNewRecord);	
   }	
	
   @RequiresPermissions({"sys:config:view"})	
   @RequestMapping({"form"})	
   public String form(Config config, Model model) {	
      model.addAttribute(ValidCodeController.ALLATORIxDEMO ("H{ErBs"), config);	
      return "modules/sys/configForm";	
   }	
}	
