package org.example;
public class App 
{
    public static void main( String[] args ) {
        CityRepository cityRepository = new CityRepository();
        City city = new City();
        city.setName("Bazar-Korgon" );
        city.setPopulation(14000);
        cityRepository.save(city);
        System.out.println(cityRepository.findById(1L));
        cityRepository.findAll();
        cityRepository.deleteById(2L);
        cityRepository.deleteAll();
        RegionRepository regionRepository = new RegionRepository();
        Region region = new Region();
        region.setName("Osh");
        region.setPopulation(1400000);
        regionRepository.save(region);
        regionRepository.findAll();
        regionRepository.findById(1L);
        regionRepository.deleteById(2L);
        StateRepository stateRepository = new StateRepository();
        State state = new State();
        state.setName("Virginia");
        state.setPopulation(40000000);
        state.setGovernor("Amanda");
        stateRepository.save(state);
        stateRepository.deleteAll();
        stateRepository.update(1L,new State("Texas","Halstead Evan",1300000));

    }
}
