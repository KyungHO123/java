package kr.kh.spring3.model.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberVO {

	private String me_id;
	private String me_pw;
	private String me_email;
	private String me_stop;
	private String me_fail;
	private String me_ms_state;
	private String me_authority;
	private String me_cookie;
	private String me_cookie_limit;

	public MemberVO(String me_id, String me_pw, String me_email) {
		this.me_id=me_id;
		this.me_pw=me_pw;
		this.me_email=me_email;
	}
}
