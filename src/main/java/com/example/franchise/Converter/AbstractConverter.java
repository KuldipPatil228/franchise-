package com.example.franchise.Converter;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

    /**
     * @param <D> DTO representation's type
     * @param <E> Domain representation's type
     */
    public abstract class AbstractConverter<D, E> {

        private final Function<D, E> toEntity;
        private final Function<E, D> toDto;

        /**
         * @param toEntity Function that converts given dto entity into the domain entity.
         * @param toDto    Function that converts given domain entity into the dto entity.
         */
        public AbstractConverter(final Function<D, E> toEntity, final Function<E, D> toDto) {
            this.toEntity = toEntity;
            this.toDto = toDto;
        }

        /**
         * @param dto DTO entity
         * @return The domain representation - the result of the converting function application on dto entity.
         */
        public final E toEntity(final D dto) {
            return toEntity.apply(dto);
        }

        /**
         * @param entity domain entity
         * @return The DTO representation - the result of the converting function application on domain entity.
         */
        public final D toDto(final E entity) {
            return toDto.apply(entity);
        }

        /**
         * @param dtos collection of DTO entities
         * @return List of domain representation of provided entities retrieved by
         * mapping each of them with the conversion function
         */
        public final List<E> toEntities(final Collection<D> dtos) {
            return dtos.stream().map(this::toEntity).collect(Collectors.toList());
        }

        /**
         * @param entities collection of domain entities
         * @return List of domain representation of provided entities retrieved by
         * mapping each of them with the conversion function
         */
        public final List<D> toDtos(final Collection<E> entities) {
            return entities.stream().map(this::toDto).collect(Collectors.toList());
        }

    }


