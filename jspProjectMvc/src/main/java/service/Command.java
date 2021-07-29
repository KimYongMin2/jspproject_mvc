package service;

import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Command {

	// GreetingCommandImpl
	// 메소드가 추상메소드
	// public abstract
	String getPage(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
