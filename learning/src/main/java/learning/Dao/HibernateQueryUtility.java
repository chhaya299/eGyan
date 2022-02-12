package learning.Dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import learning.Entity.Content;

@Repository
public class HibernateQueryUtility {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Autowired
	private LocalSessionFactoryBean factory;
	
	public Session getQuery() {
		SessionFactory sessionFactory =(SessionFactory)factory.getObject();
		Session session=sessionFactory.openSession();
		return session;
	}
	
	public List<Content> convertContent(List<Content> content){
		List<Content> original  = new ArrayList<Content>();
		
		 for(Content con:content) {
			 Content content1=new Content();
			 content1.setContentId(con.getContentId());
			 content1.setContentType(con.getContentType());
			 content1.setChapterContentId(con.getChapterContentId());
			 content1.setContentTitle(con.getContentTitle());
			 content1.setData(con.getData());
			 StringBuilder sb = new StringBuilder();
			 sb.append("data:"+con.getContentType()+";base64,");
			 sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(con.getData(),false)));
			 content1.setFileName(sb.toString());
			 
			 original.add(content1);
			 System.out.println(content1);
		 }
		return original;
	}
	
}
