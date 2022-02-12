package learning.Entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="content")
public class Content {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="content_id")
	private  int contentId;
	
	@Column(name="content_type",nullable=false)
	private String contentType;
	
	@Column(name="chapter_content_id",nullable=false)
	private int chapterContentId;
	
	@Column(name="content_title",nullable=false)
	private String contentTitle;
	
	@Column(name = "FILE_DATA",nullable=false)
	@Lob
        private byte[] data;
	
	
	
	@Transient
	private String fileName;
	
	public Content(int contentId, String contentType, int chapterContentId, String contentTitle, byte[] data,
			String fileName) {
		super();
		this.contentId = contentId;
		this.contentType = contentType;
		this.chapterContentId = chapterContentId;
		this.contentTitle = contentTitle;
		this.data = data;
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public int getChapterContentId() {
		return chapterContentId;
	}

	public void setChapterContentId(int chapterContentId) {
		this.chapterContentId = chapterContentId;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Content(int contentId, String contentType, int chapterContentId, String contentTitle, byte[] data) {
		super();
		this.contentId = contentId;
		this.contentType = contentType;
		this.chapterContentId = chapterContentId;
		this.contentTitle = contentTitle;
		this.data = data;
	}

	public Content() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Content [contentId=" + contentId + ", contentType=" + contentType + ", chapterContentId="
				+ chapterContentId + ", contentTitle=" + contentTitle + ", data=" + Arrays.toString(data) + "]";
	}
	 
	
	
}
