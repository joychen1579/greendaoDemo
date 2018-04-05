package com.joychen.daomodel.entity;

import org.greenrobot.greendao.converter.PropertyConverter;

/**
 * Created by joychen on 2018/4/4.
 */

public class UTypeConverter implements PropertyConverter<UType,String> {
    @Override
    public UType convertToEntityProperty(String databaseValue) {
        return UType.valueOf(databaseValue);
    }

    @Override
    public String convertToDatabaseValue(UType entityProperty) {
        return entityProperty.name();
    }
}
