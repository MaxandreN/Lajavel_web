package app.repository;

import app.models.Contributor;

import java.util.List;

public class ContributorsRepository {
    private static ContributorsRepository instance;
    private List<Contributor> contributorlist;

    private ContributorsRepository() {
        Contributor contributor = new Contributor("intermarché", "Gueugnon", "/img/contributors/intermarche.png", "intermarché");
        Contributor contributor2 = new Contributor("Digoin Ceramic Museum", "", "/img/contributors/Musee_Ceramique_Digoin.png", "Digoin Ceramic Museum");
        Contributor contributor3 = new Contributor("larovel", "", "/img/contributors/larovel.png", "larovel");
        Contributor contributor4 = new Contributor("And why not you ?", "", "/img/contributors/come_on.jpg", "larovel");

        this.contributorlist = List.of(contributor, contributor2, contributor3, contributor4);
    }

    public static ContributorsRepository getInstance() {
        if (instance == null) {
            instance = new ContributorsRepository();
        }
        return instance;
    }

    public static List<Contributor> findall(){
        return ContributorsRepository.getInstance().contributorlist;
    }

}
