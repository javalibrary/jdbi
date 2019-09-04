/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jdbi.v3.sqlobject.config;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.jdbi.v3.core.qualifier.Qualifier;
import org.jdbi.v3.meta.Beta;
import org.jdbi.v3.sqlobject.config.internal.RegisterQualifierFactory;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Qualifies a target with the given annotation. Use this when you want to use an annotation as a qualifier
 * but are unable to add @{@link Qualifier} to the annotation's source.
 *
 * An example use case is putting @{@link javax.annotation.Nonnull} as a qualifier on an SQL Object's fields/methods.
 *
 * @see Qualifier
 */
@Beta
@Retention(RUNTIME)
@Target({METHOD, TYPE})
@ConfiguringAnnotation(RegisterQualifierFactory.class)
public @interface RegisterQualifier {
    Class<? extends Annotation>[] value();
}