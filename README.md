# State Pattern Spike

This project contains a small support library to model the State pattern in Java, plus illustrative example scenarios ("
life" and "TCP").

What you get:

- support.state library: Context, StateRegistry, and StateFactory building blocks
- example states and models under src/test to demonstrate usage
- Maven project you can build and test locally

Overview

- Context<STATE>: Holds the current state as a Class<? extends STATE> and provides access to the active state instance
  via a StateRegistry. Thread-safe via AtomicReference.
- StateRegistry<STATE>: A thread-safe cache mapping state classes to singleton instances, delegating creation to a
  StateFactory. Uses ConcurrentHashMap and computeIfAbsent for safe, efficient creation under concurrency.
- StateFactory<STATE>: Strategy for creating state instances from their class. Examples provide simple factories.

Quick Start

1) Define your state interface and implementations (with behavior methods that accept your ContextHolder model type as
   needed).
2) Provide a StateFactory that can construct your states.
3) Create a Context with an initial state class and interact by reading current state and invoking transitions.

Example (simplified pseudo-Java)

interface MyState { /* behavior methods */ }
class Start implements MyState {}
class Next implements MyState {}

class MyStateFactory implements StateFactory<MyState> {
public MyState createState(Class<? extends MyState> cls) {
try {
return cls.getDeclaredConstructor().newInstance();
} catch (Exception e) { throw new RuntimeException(e); }
}
}

StateRegistry<MyState> registry = new StateRegistry<>(new MyStateFactory());
Context<MyState> ctx = new Context<>(registry, Start.class);

// read current state instance
MyState state = ctx.getState();

// transition by class (validated for non-null)
ctx.setState(Next.class);

Project Layout

- src/main/java/.../support/state: core library
- src/test/java: example implementations (life, tcp) using the support library
- docs/: improvement tasks and plans

Build and Test

- Requirements: Java 21 (as configured by project) and Maven
- Run tests: mvn -B -ntp -DskipTests=false test

Notes on Thread Safety

- Context uses an AtomicReference for the state class and validates non-null inputs
- StateRegistry uses computeIfAbsent for single instantiation per class under concurrency

