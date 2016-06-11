package cn.test.model;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import cn.test.model.Message;

@Entity
@Table(name = "REPLY")
public class Reply {

	@Id
	@GenericGenerator(name="idGenerator", strategy="uuid")
	@GeneratedValue(generator="idGenerator")
	String replyid;
	
	public String getReplyid() {
		return replyid;
	}

	public void setReplyid(String replyid) {
		this.replyid = replyid;
	}

	public String getMessageid() {
		return messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public String getReplymessage() {
		return replymessage;
	}

	public void setReplymessage(String replymessage) {
		this.replymessage = replymessage;
	}

	String messageid;
	String id;
	
	@Basic
	@GeneratedValue
	@Column(nullable = true)
	Timestamp createdate;
	public Timestamp getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getRemovedate() {
		return removedate;
	}

	public void setRemovedate(Timestamp removedate) {
		this.removedate = removedate;
	}

	Timestamp removedate;
	String replymessage;
}
