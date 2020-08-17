package com.example.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Comment;
import com.example.demo.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// コンストラクタを自動生成　引数はfinalなフィールド
@Component
public class DataLoader implements CommandLineRunner {
	private final CommentRepository repository;
	
	// @RequiredArgsConstrucorが自動生成するコード
	// public DataLoader(CommentRepository repository) {
	// this.repository = repository
	// }
	
	@Override
	public void run(String... args) throws Exception {
		Comment comment = new Comment();
		comment.setContent("こんにちは");
		repository.save(comment);
		
		comment = new Comment();
		comment.setContent("テストコメント");
		repository.save(comment);
	}
	// CommandLineRunner これを実装したクラスを作成すると、コマンドラインで執行するアプリケーションを作成できる
}
