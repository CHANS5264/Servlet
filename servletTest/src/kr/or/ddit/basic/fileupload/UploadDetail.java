package kr.or.ddit.basic.fileupload;

// Upload된 파일 정보를 저장하는 Class
public class UploadDetail {
	private long fileSize;
	private String fileName;
	private String uploadStatus;
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	
	
	
}
