package com.example.spring.selenium.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.util.FileCopyUtils;

import com.example.spring.selenium.annotations.LazyComponent;


@LazyComponent
public class ScreenShotUtils {

	@Autowired
	private ApplicationContext ctx;
	
	
	@Value("${screenshotpath}")
	private Path path;
	
	
	public String takeScreenShot(String imageName) throws IOException {
		File source = ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
		FileCopyUtils.copy(source, path.resolve(imageName).toFile());
		return path.toString();
	}
	
	public byte[] getScreenShot() {
		return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);
	}

}
