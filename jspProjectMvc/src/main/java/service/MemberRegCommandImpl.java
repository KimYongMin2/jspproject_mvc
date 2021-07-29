package service;

import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

public class MemberRegCommandImpl implements Command {

	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse response) {

		//.... 핵심처리
		int resultReg = 0;
		try {
			resultReg = MemberRegService.getInstance().regMember(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		request.setAttribute("resultReg", resultReg);
		
		return "/reg_view.jsp";
	}

}
