package com.issue.jusick.project.phn;

public class issue_main {

	public static void main(String[] args) throws Exception {
		issue_score_update_it it = new issue_score_update_it();
		it.it();
		issue_score_update_bio bio = new issue_score_update_bio();
		bio.bio();
		issue_score_update_edu edu = new issue_score_update_edu();
		edu.edu();
		issue_score_update_elb elb = new issue_score_update_elb();
		elb.elb();
		issue_score_update_flex flex = new issue_score_update_flex();
		flex.flex();
	}
}
