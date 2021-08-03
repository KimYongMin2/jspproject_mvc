package oldmember.dao;

import java.util.Collection;

import oldmember.domain.Member;

public class GuestDao implements Dao {

	@Override
	public Member selectByEmail(String email) {
		System.out.println("selectByEmail");
		return null;
	}

	@Override
	public void insert(Member member) {
		System.out.println("insert");

	}

	@Override
	public void update(Member member) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Member> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
