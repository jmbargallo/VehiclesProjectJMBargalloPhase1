package VehiclesProject;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Input car data
        Map<String, String> carInputs = new HashMap<>();


        System.out.println("Introduce los datos del vehiculo: ");
        System.out.print("Matricula: ");
        String matricula;
        matricula = in.nextLine();



        //Input cardata in carInputs HashMap
        carInputs.put("Plate", matricula);
        System.out.println("Marca: ");
        carInputs.put("Brand", in.nextLine());

        System.out.println("Color: ");
        carInputs.put("Color", in.nextLine());

        //Create a car

        Vehicle car = new Car(carInputs.get("Plate"), carInputs.get("Brand"), carInputs.get("Color"));


        //Add Wheels
        List<Wheel> carFrontWheels = new ArrayList<>();
        List<Wheel> carBackWheels = new ArrayList<>();
        Map<String, String> mapWheelsBrands = new HashMap<>();
        Map<String, Double> mapWheelsDiameters = new HashMap<>();

        //Front Wheels
        System.out.print("Marca ruedas delanteras: ");
        mapWheelsBrands.put("FrontWheelBrand", in.nextLine());
        System.out.print("Diámetro ruedas delanteras: ");
        double diametro1=Double.parseDouble(in.nextLine());

        mapWheelsDiameters.put("FrontWheelDiameter", diametro1);

        carFrontWheels.add(new Wheel(mapWheelsBrands.get("FrontWheelBrand"), mapWheelsDiameters.get("FrontWheelDiameter")));
        carFrontWheels.add(new Wheel(mapWheelsBrands.get("FrontWheelBrand"), mapWheelsDiameters.get("FrontWheelDiameter")));

        //Back Wheels
        System.out.print("Marca ruedas traseras: ");
        mapWheelsBrands.put("BackWheelBrand", in.nextLine());
        System.out.print("Diámetro ruedas traseras: ");
        double diametro2=Double.parseDouble(in.nextLine());

        mapWheelsDiameters.put("BackWheelDiameter", diametro2);

        carBackWheels.add(new Wheel(mapWheelsBrands.get("BackWheelBrand"), mapWheelsDiameters.get("BackWheelDiameter")));
        carBackWheels.add(new Wheel(mapWheelsBrands.get("BackWheelBrand"), mapWheelsDiameters.get("BackWheelDiameter")));

        try {
            ((Car) car).addWheels(carFrontWheels, carBackWheels);
        } catch (Exception e) {
            System.out.println("Error en los datos de las ruedas");
        }


        //Print Results
        System.out.println();
        System.out.println("Los datos del coche son:");
        System.out.println();
        System.out.println("Marca:  " + car.brand);
        System.out.println("Matricula: " + car.plate);

        System.out.println("Color: " + car.color);
        System.out.println();
        System.out.println("Ruedas");
        System.out.println();
        List<Wheel> carWheelsResult = car.wheels;

        //Print wheel data
        int contador=0;

        for (Wheel c : carWheelsResult)
        {
            contador++;
            System.out.println("Rueda "+ contador+" Marca "+c.getBrand()+" diametro "+c.getDiameter() );
            /*
            if (c.getDiameter()>4||c.getDiameter()<0.4){
                System.out.println("el diametro  es chungo");
            }
            */
        }
        /*
        if (valido==0){
            System.out.println();
            System.out.println("Este coche es mas falso que un euro de carton");
        }
                 */
    }
}
