package com.samuel.springboot_test.mappers;

public interface Mapper<Entity, Dto> {

    Dto mapTo(Entity entity);

    Entity mapFrom(Dto dto);

}
