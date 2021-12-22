package com.perfios.vfsutility;

import com.perfios.service.VfsUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.perfios")
public class VfsUtilityApplication implements CommandLineRunner {

	@Autowired
VfsUtilityService vfsUtilityService;

	public static void main(String[] args) {
		 SpringApplication.run(VfsUtilityApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

		String sourceUri= "C:\\Users\\DELL\\Desktop\\spring-application\\vfs-utility\\LocalSource\\";
		String targetUri = "sftp://sftpuser:1234@localhost:2222/sftpuser/testFolder/";
		vfsUtilityService.Copy(sourceUri,targetUri);

//		 ************This is for delete************
//		String targetUri = "sftp://sftpuser:1234@localhost:2222/sftpuser/testFolder/file1.text";
//		vfsUtilityService.delete(targetUri);

	}
}
