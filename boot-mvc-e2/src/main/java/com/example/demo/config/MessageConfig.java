package com.example.demo.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
// @Configuration 設定クラスであることを表す
public class MessageConfig {
	@Bean
	// Springに管理されつBeanの生成を示す 設定処理の本体
	public MessageSource messageSource() {
		var source = new ReloadableResourceBundleMessageSource();
		// 読み込むファイルめっでーじを指定
		source.setBasenames("classpath:i18n/messages", "classpath:i18n/ValidationMessages");
		// 文字コードをUTF-8に
		source.setDefaultEncoding("UTF-8");
		// システムの言語に関係なく、デフォルトのメッセージを返す
		source.setFallbackToSystemLocale(false);
		return source;
	}
	
	@Bean
	public LocalValidatorFactoryBean getValidator() {
		// 上記のmeesageSource()メソッドをセット
		var bean = new LocalValidatorFactoryBean();
		bean.setValidationMessageSource(messageSource());
		return bean;
	}

}
