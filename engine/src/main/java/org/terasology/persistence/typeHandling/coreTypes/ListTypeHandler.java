/*
 * Copyright 2013 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terasology.persistence.typeHandling.coreTypes;

import org.terasology.persistence.typeHandling.DeserializationContext;
import org.terasology.persistence.typeHandling.PersistedData;
import org.terasology.persistence.typeHandling.SerializationContext;
import org.terasology.persistence.typeHandling.SimpleTypeHandler;

import java.util.List;

/**
 * @author Immortius <immortius@gmail.com>
 */
public class ListTypeHandler<T> extends SimpleTypeHandler<List<T>> {
    private Class<T> contentsType;

    public ListTypeHandler(Class<T> contentsType) {
        this.contentsType = contentsType;
    }


    @Override
    public PersistedData serialize(List<T> value, SerializationContext context) {
        if (value.size() > 0) {
            return context.create(value, contentsType);
        }
        return context.createNull();
    }

    @Override
    public List<T> deserialize(PersistedData data, DeserializationContext context) {
        return context.deserializeCollection(data, contentsType);
    }
}
