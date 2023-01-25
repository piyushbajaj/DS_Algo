package LLD.Educative.BuilderPattern;

/**
 * Project: DS_Algo
 * Package: LLD.Educative.BuilderPattern
 * <p>
 * User: piyushbajaj
 * Date: 14/12/22
 * Time: 7:21 pm
 */
public class Boeing747Builder extends AircraftBuilder {

    Boeing747 boeing747;

    @Override
    public void buildCockpit() {

    }

    @Override
    public void buildEngine() {

    }

    @Override
    public void buildBathrooms() {

    }

    @Override
    public void buildWings() {

    }

    public IAircraft getResult() {
        return boeing747;
    }
}
