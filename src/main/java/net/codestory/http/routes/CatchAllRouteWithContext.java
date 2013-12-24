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

import net.codestory.http.internal.*;

class CatchAllRouteWithContext extends AbstractRoute {
  private final AnyRouteWithContext route;

  CatchAllRouteWithContext(AnyRouteWithContext route) {
    this.route = route;
  }

  @Override
  protected Object body(Context context, String[] parameters) {
    return route.body(context, parameters);
  }

  @Override
  protected boolean matchUri(String uri) {
    return true;
  }

  @Override
  protected boolean matchMethod(Context context) {
    return true;
  }

  @Override
  protected String[] parseParameters(String uri, Context context) {
    return new String[0];
  }
}