package LLD.Concept_And_Coding.L2_Strategy_Pattern.WithoutStrategyPattern;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L2_Strategy_Pattern.WithoutStrategyPattern
 * <p>
 * User: piyushbajaj
 * Date: 15/01/23
 * Time: 9:03 pm
 */
public class OffRoadVehicle extends Vehicle {
    @Override
    // same capability of SportsVehicle, hence duplicating the code
    public void drive() {
        System.out.println("Sports Drive capability");
    }
}
