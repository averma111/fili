// Copyright 2018 Yahoo Inc.
// Licensed under the terms of the Apache license. Please see LICENSE.md file distributed with this work for terms.
package com.yahoo.wiki.webservice.data.config.dimension;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yahoo.bard.webservice.data.dimension.DimensionField;
import com.yahoo.bard.webservice.util.EnumUtils;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Dimension field set template.
 * <p>
 * An example:
 * <p>
 *      {
 *          "name": "ID",
 *          "description": "Dimension ID",
 *          "tags": [
 *              "primaryKey"
 *          ]
 *      }
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WikiDimensionFieldSetsTemplate implements DimensionField {

    private final String name;
    private final String description;
    private final LinkedList<String> tags;

    /**
     * Constructor used by json parser.
     *
     * @param name        json property name
     * @param description json property description
     * @param tags        json property tags
     */
    @JsonCreator
    public WikiDimensionFieldSetsTemplate(
            @NotNull @JsonProperty("name") String name,
            @JsonProperty("description") String description,
            @JsonProperty("tags") LinkedList<String> tags
    ) {
        this.name = EnumUtils.camelCase(name);
        this.description = (Objects.isNull(description) ? "" : description);
        this.tags = (Objects.isNull(tags) ? null : new LinkedList<>(tags));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * Get dimensions tags.
     *
     * @return a set of dimension tags
     */
    public LinkedList<String> getTags() {
        return this.tags;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
