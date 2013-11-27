/**
 * Copyright (C) 2013 all@code-story.net
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package net.codestory.http.routes;

import java.lang.reflect.*;
import java.util.function.*;

import net.codestory.http.convert.*;

class ReflectionRoute extends AbstractReflectionRoute implements AnyRoute {
  ReflectionRoute(Supplier<Object> resource, Method method) {
    super(resource, method);
  }

  @Override
  public Object body(String[] pathParameters) {
    try {
      Object[] arguments = TypeConvert.convert(pathParameters, method.getParameterTypes());

      return payload(arguments);
    } catch (Exception e) {
      throw new IllegalStateException("Unable to apply resource", e);
    }
  }
}

