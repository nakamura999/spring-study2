package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
// @Entity データの入れ物
// @Id エンティティの主キーを設定
// @GeneratedValue 主キーの値を自動採番します。@Idアノテーションと一緒に設定
public class Book {
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String detail;
}
