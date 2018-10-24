package net.newture.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import net.newture.domain.User;
import net.newture.framework.util.Struts2Utils;
import net.newture.framework.util.WebUtil;

public class ServiceBase {
	/**
	 * 获取当前登录用户信息
	 * @return User对象
	 */
	public User getLoginUser() {
		HttpServletRequest request = Struts2Utils.getRequest();
		return WebUtil.getUser(request);
	}
	
	public Boolean updateFile(File file,String menuIconFileName,String route){
		OutputStream os = null;
		InputStream is = null;
		try {
			//文件输入流
			is = new FileInputStream(file);
			//设置文件保存的目录
			String uploadPath = ServletActionContext.getServletContext().getRealPath("../../../../Feedback/WebContent/upload/"+route);
			//设置目标文件
			File toFile = new File(uploadPath,menuIconFileName);
			//文件输出流
			os = new FileOutputStream(toFile);
			byte[] buffer = new byte[1024];
			int length = 0;
			//读取file文件输出到toFile文件中
			while(-1!=(length=is.read(buffer,0,buffer.length))){
				os.write(buffer);
			}
		}catch(IOException e){
			Struts2Utils.setAttribute("success", "-1");
			Struts2Utils.setAttribute("message",
					"文件上传失败：" + (e.getMessage() != null ? e.getMessage()
							: "")
							+ (e.getCause() != null ? (e.getCause().getCause() != null ? e.getCause().getCause() : "")
									: ""));
			return true;
		}finally{
			//关闭输入流和输出流
			try {
				if(is!=null){
					is.close();
					is = null;
				}
				if(os!=null){
					os.close();
					is = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
