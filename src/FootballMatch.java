public class FootballMatch {

	private Team localTeam;
	private Team visitorTeam;
	private int goalsLocal;
	private int goalsVisitor;

	public Team getLocalTeam() {
		return this.localTeam;
    }

	public void setLocalTeam(Team localTeam) {
		this.localTeam = localTeam;
	}

	public Team getVisitorTeam() {
		return this.visitorTeam;
	}

	public void setVisitorTeam(Team visitorTeam) {
		this.visitorTeam = visitorTeam;
	}

	public int getGoalsLocal() {
		return this.goalsLocal;
	}

	public void setGoalsLocal(int goalsLocal) {
		this.goalsLocal = goalsLocal;
	}

	public int getGoalsVisitor() {
		return this.goalsVisitor;
	}

	public void setGoalsVisitor(int goalsVisitor) {
		this.goalsVisitor=goalsVisitor;
	}
}