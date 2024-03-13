package kr.kh.spring.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {
	private String me_id;
	private String me_pw;
	private String me_ms_state;
	private String me_email;
	private String me_authority;
	private String me_stop;
	private int me_fail;
	
	public MemberVO(String me_id, String me_pw, String me_email) {
		this.me_id=me_id;
		this.me_pw=me_pw;
		this.me_email=me_email;
	}

	@Override
	public String toString() {
		return "MemberVO [me_id=" + me_id + ", me_pw=" + me_pw + ", me_email=" + me_email + "]";
	}
	
}
