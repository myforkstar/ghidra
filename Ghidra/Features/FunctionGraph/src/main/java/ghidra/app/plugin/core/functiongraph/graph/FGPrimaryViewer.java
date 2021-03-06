/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ghidra.app.plugin.core.functiongraph.graph;

import java.awt.Dimension;

import ghidra.app.plugin.core.functiongraph.graph.vertex.FGVertex;
import ghidra.app.plugin.core.functiongraph.graph.vertex.FGVertexTooltipProvider;
import ghidra.graph.viewer.*;
import ghidra.graph.viewer.layout.VisualGraphLayout;

public class FGPrimaryViewer extends GraphViewer<FGVertex, FGEdge> {

	FGPrimaryViewer(FGComponent graphComponent, VisualGraphLayout<FGVertex, FGEdge> layout,
			Dimension size) {
		super(layout, size);

		setVertexTooltipProvider(new FGVertexTooltipProvider());
		setGraphOptions(graphComponent.getFucntionGraphOptions());
	}

	@Override
	protected VisualGraphViewUpdater<FGVertex, FGEdge> createViewUpdater() {
		return new FGViewUpdater(this, getVisualGraph());
	}
}
