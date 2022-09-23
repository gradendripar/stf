package com.test4.stf;

import com.test4.stf.domain.Post;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.test4.stf.mapper")
public class StfApplication {

	public static void main(String[] args) {
		SpringApplication.run(StfApplication.class, args);
	}

}
