package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(1).size());
        assertTrue(cityList.getCities(1).contains(city));
    }

    @Test
    public void testDelete()
    {
        CityList cityList = new CityList();
        City city1 = new City("Jessore","Khulna");
        City city2 = new City("Pabna","Rajshahi");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertTrue(!cityList.getCities(1).contains(city1));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testDeleteException(){
        CityList cityList = new CityList();
        City city1 = new City("Jessore","Khulna");
        City city2 = new City("Pabna","Rajshahi");
        cityList.add(city1);
        cityList.add(city2);

        cityList.delete(city1);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city1);
        });
    }

    @Test
    public void testCount()
    {
        CityList cityList = new CityList();
        City city1 = new City("Jessore","Khulna");
        City city2 = new City("Pabna","Rajshahi");
        cityList.add(city1);
        cityList.add(city2);
        assertEquals(2,cityList.count());

        cityList.delete(city1);
        assertEquals(1,cityList.count());
    }

    /**
     * This is a test method for GetCities.
     */
    @Test
    public void testGetCities() {
        CityList cityList = new CityList();
        City city1 = new City("ZZZZZZZZ","CD");
        cityList.add(city1);
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));

        City city2 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city2);

        assertEquals(0, city2.compareTo(cityList.getCities(1).get(0)));
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(1)));
    }

    @Test
    public void testGetCitiesWithProvince() {
        CityList cityList = new CityList();
        City city1 = new City("ZZZZZZZ","CD");
        cityList.add(city1);
        assertEquals(0, city1.compareTo(cityList.getCities(1).get(0)));

        City city2 = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city2);

        assertEquals(0, city1.compareTo(cityList.getCities(2).get(0)));
        assertEquals(0, city2.compareTo(cityList.getCities(2).get(1)));
    }
}
