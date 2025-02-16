package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	protected Innlegg[] innleggtabell;
	protected int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		boolean funnet = false;
		int pos = 0;
		while(pos < nesteledig && !funnet) {
			if (innleggtabell[pos].erLik(innlegg)) {
				funnet = true;
			}
			else {
				pos++;
			}	
		}
		if (funnet) {
			return pos;
		}
		else {
			return -1;
		}
	}

	public boolean finnes(Innlegg innlegg) {
		int pos = finnInnlegg(innlegg);
		if (pos >= 0) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean ledigPlass() {
		if(nesteledig >= innleggtabell.length) {
			return false;
		}
		else {
			return true;
		}

	}
	
	public boolean leggTil(Innlegg innlegg) {
		if(!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String tabStr = "" + nesteledig + "\n";
		for(int i = 0; i < nesteledig; i++) {
			tabStr += innleggtabell[i].toString();
		}
		return tabStr;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}