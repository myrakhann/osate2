package org.osate.ge.internal.diagram.runtime.layout.connections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.osate.ge.graphics.Point;
import org.osate.ge.internal.diagram.runtime.Dimension;

// TODO: Rename
public class TestModel {
	public static LineSegmentFinderDataSource<TestElement> createDataSource() {
		final List<TestElement> objects = new ArrayList<>();
		addNonPort(objects, null, new Point(100, 100), new Dimension(200, 200));
		addNonPort(objects, null, new Point(200, 350), new Dimension(400, 50));
		addNonPort(objects, null, new Point(500, 100), new Dimension(200, 200));

		// TestObject.createPort(objects.get(1), new Point(500, 100), new Dimension(50, 200),
		// TODO: Reeenable connection points
//		TestObject.createPort(objects.get(1), new Point(550, 150), new Dimension(50, 50),
//				new Point[] { /* new Point(20, 10), new Point(20, 30), new Point(20, 50) */ },
//				new Point[] { /* new Point(60, 10), new Point(60, 30), new Point(60, 50) */ });

		final LineSegmentFinderDataSource<TestElement> testDataSource = new LineSegmentFinderDataSource<TestElement>() {
			@Override
			public List<TestElement> getObjects() {
				return objects;
			}


			@Override
			public TestElement getParent(TestElement e) {
				return e.getParent();
			}

			@Override
			public Point getPosition(final TestElement e) {
				return e.getPosition();
			}

			@Override
			public Rectangle getBounds(final TestElement e) {
				return e.getBounds();
			}


//			@Override
//			public TestElement getParent(final TestElement o) {
//				// TODO: Needed for connection points too
//				return o.parent;
//			}
//
//			@Override
//			public List<TestObject> getChildren(final TestElement o) {
//				if (o == null) {
//					return objects;
//				} else {
//					return ((TestObject) o).children;
//				}
//			}
//
//			@Override
//			public int getNumberOfConnectionPoints(final TestElement o) {
//				return ((TestObject) o).connectionPoints.size();
//			}
//
//			@Override
//			public TestElement getConnectionPoint(final TestElement o, final int index) {
//				return ((TestObject) o).connectionPoints.get(index);
//			}
//
//			@Override
//			public Point getConnectionPointPosition(final TestElement o) {
//				return ((TestConnectionPoint) o).position;
//			}
//
//			@Override
//			public Rectangle getBounds(TestElement o) {
//				return ((TestObject) o).bounds;
//			}
//
//			@Override
//			public Rectangle getConnectionPointSegmentBounds(final TestElement o, final int index) {
//				return ((TestObject) o).connectionPoints.get(index).segmentBounds;
//			}
		};

		return testDataSource;
	}

	/**
	 * Represents a box with connection points on left and right.
	 * @param parent must not be a port
	 * @param position
	 * @param size
	 * @return
	 */
	public static void addNonPort(final Collection<TestElement> elements, final TestObject parent,
			final Point position, final Dimension size) {

		final TestObject newObj = new TestObject(parent, position, size);
		elements.add(newObj);

		elements.add(new TestConnectionPoint(newObj, new Point(position.x, position.y + size.height / 2.0)));
		elements.add(
				new TestConnectionPoint(newObj, new Point(position.x + size.width, position.y + size.height / 2.0)));
	}

	/**
	 *
	 * @param parent
	 * @param position
	 * @param size
	 * @param exteriorConnectionPoint relative to position
	 * @param interiorConnectionPoint relative to position
	 * @return
	 */
//	public static TestObject createPort(final TestObject parent, final Point position, final Dimension size,
//			final Point[] exteriorConnectionPointPositions, final Point[] interiorConnectionPointPositions) {
//		Objects.requireNonNull(parent, "parent must not be null");
//
//		final List<TestConnectionPoint> connectionPoints = new ArrayList<>();
//
//		// Constrain the segment bounds of the interior and exterior ports so that the segments generated by the graph builder will be horizontal and will
//		// only extend outwards in one direction. In a real implementation this would need to consider the side to which the port is docked.
//		//final Rectangle nonPortParentBounds = getNonPortBounds(parent, 1);
//
//		for (final Point interiorConnectionPointPosition : interiorConnectionPointPositions) {
//			final Rectangle interiorPortSegmentBounds;
//			if (nonPortParentBounds == null) {
//				throw new RuntimeException("Unexpected case");
//			} else {
//				interiorPortSegmentBounds = new Rectangle(
//						new Point(position.x + interiorConnectionPointPosition.x,
//								position.y + interiorConnectionPointPosition.y),
//						new Point(nonPortParentBounds.max.x, position.y + interiorConnectionPointPosition.y));
//			}
//
//			connectionPoints.add(new TestConnectionPoint(new Point(position.x + interiorConnectionPointPosition.x,
//					position.y + interiorConnectionPointPosition.y), interiorPortSegmentBounds));
//		}
//
//		final Rectangle nonPortGrandparentBounds = getNonPortBounds(parent, 2);
//		for (final Point exteriorConnectionPointPosition : exteriorConnectionPointPositions) {
//			final Rectangle exteriorPortSegmentBounds;
//			if (nonPortGrandparentBounds == null) {
//				exteriorPortSegmentBounds = new Rectangle(
//						new Point(Double.NEGATIVE_INFINITY, position.y + exteriorConnectionPointPosition.y),
//						new Point(position.x + exteriorConnectionPointPosition.x,
//								position.y + exteriorConnectionPointPosition.y));
//			} else {
//				exteriorPortSegmentBounds = new Rectangle(
//						new Point(nonPortGrandparentBounds.min.x, position.y + exteriorConnectionPointPosition.y),
//						new Point(position.x + exteriorConnectionPointPosition.x,
//								position.y + exteriorConnectionPointPosition.y));
//			}
//			connectionPoints.add(new TestConnectionPoint(new Point(position.x + exteriorConnectionPointPosition.x,
//					position.y + exteriorConnectionPointPosition.y), exteriorPortSegmentBounds));
//		}
//
//		return new TestObject(parent, true, position, size));
//	}

	// TODO: Document. Need bounds or position but not both. Could have a single POJO that is used instead of an interface.
	private static interface TestElement {
		TestElement getParent();
		Rectangle getBounds();

		Point getPosition();
	}

	private static class TestConnectionPoint implements TestElement {
		public final TestElement parent;
		public final Point position;

		public TestConnectionPoint(final TestElement parent, final Point position) {
			this.parent = parent;
			this.position = position;
		}

		@Override
		public TestElement getParent() {
			return parent;
		}

		@Override
		public Rectangle getBounds() {
			return null;
		}

		@Override
		public Point getPosition() {
			return position;
		}
	}

	private static class TestObject implements TestElement {
		public final TestElement parent;
		public final Rectangle bounds;

		private TestObject(final TestObject parent, final Point position, final Dimension size) {
			this.parent = parent;
			this.bounds = new Rectangle(position, new Point(position.x + size.width, position.y + size.height));
		}

		@Override
		public TestElement getParent() {
			return parent;
		}

		@Override
		public Rectangle getBounds() {
			return bounds;
		}

		@Override
		public Point getPosition() {
			return null;
		}
	}
}
