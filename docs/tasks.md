# Improvement Tasks Checklist

Below is an enumerated, logically ordered checklist of actionable improvements for the codebase. Each item is prefixed
with a checkbox placeholder for tracking.

1. [x] Add a top-level README with usage overview
    - [x] Describe the purpose of the support state library (Context, StateRegistry, StateFactory) and how the
      examples (life, TCP) use it.
    - [x] Include a quick-start code snippet (creating a factory, context, and state transitions).
    - [x] Document project layout and how to run tests with Maven.

2. [x] Strengthen type-safety and remove unchecked casts
    - [x] Replace or refactor ContextHolder#getStateClass which currently does an unchecked cast; consider returning
      Class<? extends STATE> or Optional<Class<? extends STATE>>.
    - [x] Add @SuppressWarnings annotations only where strictly necessary, coupled with rationale.

3. [ ] Improve state transition API ergonomics and safety
    - [ ] Add a helper method on Context to transition via instance: setState(STATE newState) that registers and
      switches atomically.
    - [ ] Provide a convenience method: transition(Function<STATE, Class<? extends STATE>>) to compute next state based
      on current state.
    - [ ] Introduce validation hooks to optionally prevent illegal transitions (e.g., via a TransitionPolicy or
      validator strategy).

4. [ ] Enhance concurrency guarantees
    - [x] Review Context#setState for atomicity of reading current state and setting next state (AtomicReference is used
      for class ref only). Consider using getAndSet with clear semantics.
    - [x] Ensure StateRegistry#getState uses computeIfAbsent to avoid double-lookup and to simplify concurrent creation
      logic.
    - [ ] Document thread-safety guarantees for Context, StateRegistry, and usage patterns in multi-threaded scenarios.

5. [ ] Make StateFactory extensible and developer-friendly
    - [ ] Provide a ReflectiveStateFactory implementation that can instantiate states given zero-arg constructors.
    - [ ] Provide a MapBackedStateFactory registration API (register(Class, Supplier)) for explicit wiring without
      conditionals.
    - [ ] Document guidance on composing factories (decorators for instrumentation, caching, etc.).

6. [ ] Refine StateRegistry lifecycle and memory profile
    - [ ] Consider optional weak-referenced caching (e.g., WeakHashMap) to allow states to be GC’d in long-lived
      applications.
    - [ ] Provide a clear eviction strategy or a way to reset/clear the registry when needed (e.g., clear(), remove(
      Class)).
    - [ ] Add metrics hooks (size, hit/miss counters) for observability in larger systems.

7. [ ] Clarify state identity and immutability assumptions
    - [ ] Decide and document whether state instances are intended to be singletons per Class (current behavior) or
      per-context instances.
    - [ ] If per-class singletons remain, ensure all state classes are stateless/immutable by convention and document
      the constraint.

8. [x] Introduce explicit null-safety and preconditions
    - [x] Add Objects.requireNonNull checks in constructors and setters (Context, StateRegistry, ContextHolderFactory)
      for stateFactory, initialState, etc.
    - [x] Validate that setState does not accept null; throw meaningful exceptions early.

9. [x] Clean up ContextHolderFactory API
    - [x] Remove or utilize the unused contextWrapperClass field; if not needed, delete to reduce confusion.
    - [ ] Add Javadoc explaining the responsibilities and typical usage of the factory.

10. [ ] Improve logging and diagnostics
    - [ ] Add optional logging hooks around state transitions (from -> to) in Context to aid debugging (feature-flagged
      or via a listener interface).
    - [ ] Provide a StateTransitionListener interface and allow clients to register listeners on Context or
      StateRegistry.

11. [ ] API documentation and Javadoc coverage
    - [ ] Add Javadoc to all public types and methods in support.state package explaining thread-safety, lifecycle, and
      typical usage.
    - [ ] Add examples in Javadoc showing correct transition usage and error handling.

12. [ ] Error handling and developer feedback
    - [ ] Standardize exception messages and types for invalid transitions and unknown state classes (e.g.,
      IllegalArgumentException vs IllegalStateException).
    - [ ] Provide a dedicated exception type (e.g., UnknownStateException) for clarity.

13. [ ] Testing: unit and behavior coverage for support library
    - [ ] Add unit tests for Context behavior (initial state, setState, concurrent transitions).
    - [ ] Add unit tests for StateRegistry caching semantics and concurrency (single instantiation per class).
    - [ ] Add tests for new factories (ReflectiveStateFactory, MapBackedStateFactory).
    - [ ] Add tests for transition validators/policies and listeners if implemented.

14. [ ] Example enhancements and consistency
    - [ ] In example states (life, tcp), ensure transitions use Context helper methods once added for consistency.
    - [ ] Review LifeState default methods that throw IllegalStateException; align exceptions with standardized error
      handling.
    - [ ] Add a small README in test package describing the scenarios and how to extend them.

15. [ ] CI/CD and build hygiene
    - [ ] Add a simple GitHub Actions workflow (mvn -B -ntp -DskipTests=false test) to ensure build and tests run on
      PRs.
    - [ ] Configure Maven Surefire and Failsafe plugins explicitly; ensure Java version compatibility is declared in
      pom.xml.
    - [ ] Add spotbugs/checkstyle or equivalent for static analysis and style consistency (optional but recommended).

16. [ ] Dependency and version management
    - [ ] Ensure SLF4J binding is appropriately configured for tests (avoid multiple bindings, provide test runtime
      binding like slf4j-simple).
    - [ ] Pin plugin versions in the pom.xml for reproducibility.

17. [ ] Packaging and distribution readiness
    - [ ] Prepare the support library for potential publishing (artifact coordinates, license, SCM, developers, Maven
      Central requirements) if desired.
    - [ ] Separate examples from the core library module if this grows (consider multi-module Maven with core and
      examples).

18. [ ] Developer ergonomics and DX
    - [ ] Provide a simple builder for Context that accepts a StateFactory, initial state, and optional
      listeners/validators.
    - [ ] Offer a small Kotlin DSL sample (if Kotlin is in scope in the future) to demonstrate fluent transitions.

19. [ ] Performance considerations
    - [ ] Benchmark StateRegistry#getState with different map strategies and creation pathways; document results.
    - [ ] Consider using ClassValue for per-class caching if appropriate.

20. [ ] Security/hardening (general good practices)
    - [ ] Validate reflective factory does not instantiate arbitrary classes outside of the registered/allowed set.
    - [ ] Ensure no logs leak sensitive information (applies if integrating into broader systems).

21. [ ] Housekeeping and consistency
    - [ ] Ensure consistent package naming and visibility (minimize public surface area, prefer package-private where
      feasible).
    - [ ] Align naming: getStateName vs getStateClass; ensure symmetrical APIs and consistent terminology in docs.
