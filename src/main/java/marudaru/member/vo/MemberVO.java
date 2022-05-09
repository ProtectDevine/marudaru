package marudaru.member.vo;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MemberVO {

	@NotEmpty
	String memId;
	String memPass;
	String memEmail;
	String memNick;
}
