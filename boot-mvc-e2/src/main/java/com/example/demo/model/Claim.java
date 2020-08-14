package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Claim {
	@NotBlank
	@Size(max= 60)
	private String name;
	
	@NotBlank
	@Size(max= 254)
	private String address;
	
	@NotBlank
	@Pattern(regexp = "[0-9-]*")
	// 半角数字かハイフン
	private String phoneNumber;
	
	@NotNull
	@Min(1000)
	@NumberFormat(pattern = "#,###")
	// 数値へ変換（指定パターンの文字列を、数値に型変換）
	private BigDecimal price;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate purchaseDate;
	
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	// 日付へ変換（ISOパターンの文字列を、日付に型変換）
	private LocalDate paymentDeadline;
}
