package klasedomaci;

public class TestStudent {

	public static void main(String[] args) {
		Predmet[] pr = {new Predmet("Matematika", "MAT1"), new Predmet("Informatika","INF1"),new Predmet("Java","JAV1"),new Predmet("ITBootCamp","ITB1")};
        Ocena[] o1 = {new Ocena(55,pr[0]),new Ocena(48,pr[1]),new Ocena(65,pr[3]),new Ocena(67,pr[2])};
        Ocena[] o2 = {new Ocena(49,pr[0]),new Ocena(90,pr[1]),new Ocena(77,pr[3]),new Ocena(85,pr[2])};
        Ocena[] o3 = {new Ocena(88,pr[0]),new Ocena(68,pr[1]),new Ocena(77,pr[3]),new Ocena(100,pr[2])};
        Ocena[] o4 = {new Ocena(90,pr[0]),new Ocena(71,pr[1]),new Ocena(81,pr[3]),new Ocena(50,pr[2])};

        Student[] students = {
                new Student("Petar Peric","2704989456547",o1),
                new Student("Katarina Katic","2704997956752",o2),
                new Student("Carli Caplin","2704991456882",o3),
                new Student("Jovana Jovic","2112001455798",o4)
        };

        System.out.print("Prosecna ocena 1. studenta: ");
        System.out.println(students[0].getProsecnaOcena());
        System.out.println();

        System.out.print("Datum rodjenja 2. studenta: ");
        System.out.println(students[1].getDatumRodjenja());
        System.out.println();

        System.out.print("Ime 3. studenta: ");
        System.out.println(students[2].getIme());
        System.out.println();

        System.out.print("Prezime 4. studenta: ");
        System.out.println(students[3].getPrezime());
        System.out.println();

        System.out.print("Najbolja ocena 1. studenta: ");
        System.out.println(students[0].najboljaOcena());
        System.out.println();

        System.out.println("Studenti stariji od 21 godinu: ");
        for(Student s : students){
            if(Student.starijiOd(s,21)){
                System.out.println(s.getPotpis());
            }
        }
        System.out.println();

        System.out.println("Studenti sa prosekom vecim od 8: ");
        Student[] studentsProsek = Student.prosekVeciOd(students,8);
        for(Student s : studentsProsek){
            System.out.println(s.getPotpis());
        }


	}

}
