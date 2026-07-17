# Decision log

Every significant decision, the reasoning, and what we rejected. New decisions get an
entry; changed decisions get amended, not deleted — the history is part of the learning.

---

## D1 — Language: Java 21, plain JDK only (until Phase 7)

**Decided:** 2026-07-17 · **Status:** accepted

Java was a given (it's the language Daan wants to learn). The real decision is **no
external libraries** through Phase 6: windowing and pixels via `java.awt`, sound via
`javax.sound`. Everything else — vectors, matrices, rasterizer — we write ourselves.

- *Why:* every dependency we add is a thing that "just works" without being understood,
  which defeats the purpose. The JDK alone is genuinely enough for a Doom-style game.
- *Rejected:* JavaFX (nicer API, but another framework to learn and it hides the pixel
  buffer behind more layers), JOML math library (writing `Vec3`/`Mat4` ourselves *is*
  the curriculum).

## D2 — Engine approach: software renderer first; OpenGL port is optional, after shipping

**Decided:** 2026-07-17 · **Status:** accepted, with a scope amendment

Daan chose "software first, then OpenGL." **Amendment after pushback:** the software
renderer is not a warm-up — it carries the *entire finished game* (Phases 1–6). The
OpenGL/LWJGL port is Phase 7, explicitly optional, decided only after the game ships.

- *Why the amendment:* "build a small one, then rebuild for real" sounds efficient but
  usually means building the same game twice and shipping neither. A software renderer
  is fully capable of a Doom-style FPS (Doom itself was one). Shipping one complete game
  beats half-finishing two engines. And the Phase 4 engine/game split means a later GPU
  port replaces only the renderer, so nothing is wasted by deferring.
- *Rejected:* starting directly on OpenGL (LWJGL is boilerplate-heavy and conceptually
  opaque for a first-time programmer — you'd be copying incantations, not learning);
  building both renderers in parallel.

## D3 — Game: retro first-person dungeon crawler, grid-based levels, sprite enemies

**Decided:** 2026-07-17 · **Status:** accepted

- *Why:* indoor scenes are the cheapest thing a software renderer can draw (small rooms,
  fog hides the draw distance); grid-based maps (Wolfenstein/Doom style) make level
  building, collision, and enemy pathing all dramatically simpler; billboarded sprite
  enemies avoid 3D character modeling and animation entirely — the single biggest scope
  trap for a solo first game.
- *Rejected:* voxel world (chunk meshing and world generation are a second engine's
  worth of work), outdoor scenes (terrain + long draw distances are where software
  renderers die).

## D4 — Windowing/pixels: `JFrame` + `BufferedImage` backed by an `int[]`, via `BufferStrategy`

**Decided:** 2026-07-17 · **Status:** accepted

One window, one pixel array; the whole engine writes colors into `int[]` and we blit it
once per frame.

- *Why:* it is the shortest path from "code" to "pixel," it's fast enough (this exact
  setup comfortably does 60 FPS at 1280×720 for our workload), and it makes the renderer
  pure logic — testable, debuggable, no framework in the hot path.
- *Rejected:* `Graphics2D` draw calls for game rendering (we'd be using Java's renderer
  instead of writing ours), JavaFX `Canvas` (same reason, more machinery).

## D5 — Build tool: Gradle via wrapper · IDE: whatever runs, likely IntelliJ IDEA CE or VS Code

**Decided:** 2026-07-17 · **Status:** accepted (IDE choice open until Phase 0.1)

- *Why Gradle:* de-facto standard for Java games, and the wrapper (`./gradlew`) means
  nothing extra to install. One `build.gradle`, no modules until we need them.
- *Why not decide the IDE here:* religious topic, zero long-term consequences. We pick
  in Phase 0.1 based on what feels comfortable in the first hour.

## D6 — Resolution strategy: render internally at low resolution, scale up

**Decided:** 2026-07-17 · **Status:** accepted

The engine renders to a small internal buffer (starting point: 320×180 or 640×360) and
scales it to the window.

- *Why:* software rendering cost scales with pixel count — 320×180 is ~36× cheaper than
  4K. And the chunky-pixel look *is* the retro aesthetic we chose. This single decision
  is what makes D2 comfortably feasible.

---

## Open decisions (to grill later, at the phase where they matter)

- **O1 (Phase 2):** left- vs right-handed coordinate system, Y-up vs Z-up. Small choice,
  permanent consequences — we'll pick when we can see it on screen.
- **O2 (Phase 3):** per-pixel perspective-correct texturing everywhere, or embrace some
  PS1-style affine wobble for speed/aesthetic?
- **O3 (Phase 4):** pure grid walls (Wolfenstein-style, simpler) vs allowing arbitrary
  geometry per cell (sloped floors, diagonal walls — prettier, harder).
- **O4 (Phase 5):** melee, ranged, or both? Affects enemy design and feel.
- **O5 (after Phase 6):** do Phase 7 (OpenGL port) at all — or start game #2 with the
  engine we have?
