package applications;

import java.util.*;
import java.util.stream.Collectors;

public class HandleApplications {

	Set<Skill> skillsSet = new HashSet<>();
	Set<Position> positionsSet = new HashSet<>();
	Set<Applicant> applicantsSet = new HashSet<>();

	public void addSkills(String... names) throws ApplicationException {

		for (String s : names) {
			for (Skill sk : skillsSet) {
				if (sk.getName().equals(s))
					throw new ApplicationException();
			}
			Skill sk = new Skill(s);
			skillsSet.add(sk);
			sk.setHa(this);
		}
	}

	public void addPosition(String name, String... skillNames)
			throws ApplicationException {

		for (Position po : positionsSet) {
			if (po.getName().equals(name))
				throw new ApplicationException();
		}
		Position poNew = new Position(name);
		positionsSet.add(poNew);
		for (String s : skillNames) {
			Skill sks = null;
			for (Skill sk : skillsSet) {
				sks = sk;
				if (sk.getName().equals(s)) {
					break;
				}
			}
			if (sks == null)
				throw new ApplicationException();
			poNew.addSkill(sks);
		}
	}

	public Skill getSkill(String name) {
		for (Skill sk : skillsSet) {
			if (sk.getName().equals(name))
				return sk;
		}
		return null;
	}

	public Position getPosition(String name) {
		for (Position po : positionsSet) {
			if (po.getName().equals(name))
				return po;
		}
		return null;
	}

	public void addApplicant(String name, String capabilities)
			throws ApplicationException {
		for (Applicant aa : applicantsSet) {
			if (aa.getName().equals(name))
				throw new ApplicationException();
		}
		Applicant appNew = new Applicant(name);

		Scanner sc = new Scanner(capabilities);
		sc.useDelimiter(":,");
		while (sc.hasNext()) {
			String skillsearch = sc.next();
			boolean found = false;
			Skill foundSkill = null;
			for (Skill sk : skillsSet) {
				if (sk.getName().equals(skillsearch)) {
					found = true;
					foundSkill = sk;
					break;
				}
			}
			if (!found)
				throw new ApplicationException();
			int level = sc.nextInt();
			if (level < 1 || level > 10)
				throw new ApplicationException();
			appNew.addSkillLevel(foundSkill, level);
		}
	}

	public String getCapabilities(String applicantName)
			throws ApplicationException {
		Applicant app = null;
		for (Applicant aa : applicantsSet) {
			if (aa.getName().equals(applicantName))
				app = aa;
		}
		List<String> lstr = new ArrayList<String>();
		int i = 0;
		for (Skill sk : app.getSkills()) {
			String s = sk.getName() + ":" + app.getLevels().get(i++);
			lstr.add(s);
		}
		// lstr.sort((s1, s2) -> s1.compareTo(s2));
		Collections.sort(lstr);
		// lstr.sort(Comparator.comparing((s1, s2) -> s1.compareTo(s2)));
		// ???
		StringBuilder resstr = new StringBuilder();
		for (String el : lstr) {
			resstr.append(el + ",");
		}
		resstr.reverse().deleteCharAt(0).reverse();
		return resstr.toString();
	}

	public void enterApplication(String applicantName, String positionName)
			throws ApplicationException {
		Position fPos = null;
		for (Position po : positionsSet) {
			if (po.getName().equals(positionName)) {
				fPos = po;
				break;
			}
		}
		if (fPos == null) throw new ApplicationException();
		Applicant fApp = null;
		for (Applicant app : applicantsSet) {
			if (app.getName().equals(applicantName)) {
				fApp = app;
				break;
			}
		}
		if (fApp == null) throw new ApplicationException();
		
		if ( !(fApp.getSkills().containsAll(fPos.getSkills()) ))
				throw new ApplicationException();

		if (fApp.isYetCandidate()) throw new ApplicationException();
		fApp.setYetCandidate(true);
		fPos.addCandidate(fApp);
	}

	public int setWinner(String applicantName, String positionName)
			throws ApplicationException {
		Position fPos= null;
		for (Position p : positionsSet) {
			if (p.getName().equals(positionName)) 
				fPos = p;
		}
		if (fPos == null) throw new ApplicationException();

		Applicant fApp = null;
		for (Applicant a : applicantsSet) {
			if (a.getName().equals(applicantName)) 
				fApp = a;
		}
		if (fApp == null) throw new ApplicationException();
		
		if (! (fPos.getApplicants().contains(fApp))) 
			throw new ApplicationException();
		int sumOfAppSillk = fApp.getLevels().stream().collect(Collectors.summingInt(l -> l));
		int numOfSkill = fPos.getSkills().size();
		
		fPos.
		
		
		return 0;
	}

	public SortedMap<String, Long> skill_nApplicants() {
		return null;
	}

	public String maxPosition() {
		return null;
	}
}
