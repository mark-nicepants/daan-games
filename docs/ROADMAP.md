# Roadmap

Seven phases, each ending in something visible and running. Time estimates assume
~10 hours/week and include learning time, not just typing time. They will be wrong —
estimates always are — but they set expectations: **this is roughly a 5–6 month journey
to a shipped game.** That's normal and worth it.

The golden rule: **we do not start a phase until the previous phase's milestone runs
and you can explain how it works.**

---

## Phase 0 — Learn to program (Java fundamentals)

**~3 weeks · Milestone: a text-based dungeon crawler that runs in the terminal**

You can't build an engine without the basics, so we learn them *inside the theme of the
project* — the final Phase 0 project is the text-only ancestor of the real game.

- **0.1** Tooling: learn to run `java`, and git basics (`add` / `commit` / `log`).
  First program: print a dungeon banner. (Gradle deferred to 0.5 — one new tool at a time.)
- **0.2** Values and control flow: variables, types (`int`, `double`, `boolean`,
  `String`), `if`/`else`, loops. Project: number-guessing game.
- **0.3** Methods and arrays: functions, parameters, return values, arrays and 2D arrays.
  Project: print a dungeon map from a 2D `char` array.
- **0.4** Objects and classes: what a class is, fields, constructors, `new`, references.
  Project: `Player`, `Room`, `Monster` classes.
- **0.5** Collections and organization: `ArrayList`, `HashMap`, packages, splitting code
  across files. Set up Gradle (via wrapper) now that there's a project worth building.
- **0.6** **Milestone project:** text dungeon crawler — move between rooms with
  `n/s/e/w`, fight a monster (simple turn-based combat), find a key, escape.

*Why this matters later: the 2D map array in 0.3 literally becomes the level format of
the 3D game. The game loop of 0.6 becomes the real game loop.*

---

## Phase 1 — Pixels and the game loop (2D)

**~2 weeks · Milestone: a smooth 60 FPS 2D top-down dungeon you can walk around with WASD**

Before 3D, we learn to own the screen.

- **1.1** Open a window (`JFrame`) and get direct access to its pixels
  (`BufferedImage` + `BufferStrategy`). Fill the screen with a color by writing to an
  `int[]` array. *This pixel array is the foundation of the entire engine.*
- **1.2** The game loop: update → render → repeat. Fixed timestep, delta time, FPS
  counter. Why `Thread.sleep` alone is wrong.
- **1.3** Drawing primitives: pixels, lines (Bresenham), rectangles, and blitting images.
- **1.4** Keyboard input (`KeyListener`, key-state array) — smooth held-key movement.
- **1.5** **Milestone:** top-down view of the Phase 0 dungeon map, player square walks
  around, walls block movement (first collision detection!).

---

## Phase 2 — Into the third dimension (math + wireframe)

**~3 weeks · Milestone: fly through a wireframe 3D world with WASD + mouse look**

The math phase. We go slowly and visually — every concept gets rendered the moment
we learn it.

- **2.1** Vectors: what `(x, y, z)` means, addition, scaling, length, dot product,
  cross product. We write our own `Vec3` class and unit-test it.
- **2.2** Perspective projection: why distant things look small, and the two-line
  formula that turns a 3D point into a 2D screen pixel.
- **2.3** First 3D render: the 8 corners of a cube, projected and connected with the
  line-drawing code from Phase 1. A wireframe cube!
- **2.4** Rotation and matrices: our own `Mat4` class, rotation/translation/scale,
  why matrix multiplication order matters. The cube spins.
- **2.5** The camera: view transforms (moving the world instead of the camera),
  WASD movement, mouse look (yaw/pitch).
- **2.6** Clipping fundamentals: what happens when geometry goes behind the camera,
  near-plane clipping for lines.
- **2.7** **Milestone:** wireframe dungeon — the 2D map extruded into 3D wall outlines,
  free-fly camera.

---

## Phase 3 — The rasterizer (solid, textured, lit)

**~4 weeks · Milestone: walk through a textured, lit 3D room — it finally looks like a game**

The heart of the engine. This is the hardest and most rewarding phase.

- **3.1** Filled triangles: scanline/edge-function rasterization — turning three points
  into a filled shape, one pixel row at a time.
- **3.2** Depth: the z-buffer — how the engine knows which surface is in front.
- **3.3** Backface culling and triangle clipping against the near plane.
- **3.4** Texture mapping: UV coordinates, sampling a texture image per pixel, and
  **perspective correction** (the famous PS1 wobble is what happens without it).
- **3.5** Lighting: surface normals, Lambert diffuse ("brightness = how directly the
  light hits the surface"), simple distance fog for dungeon atmosphere.
- **3.6** Performance pass #1: measuring frame time, why `int[]` beats objects in hot
  loops, avoiding allocation per frame.
- **3.7** **Milestone:** a textured room (stone walls, floor, ceiling) with a torch-like
  light and fog, walkable in first person at 60 FPS.

---

## Phase 4 — From renderer to engine

**~3 weeks · Milestone: walk through a multi-room dungeon loaded from a level file, with real collision**

A renderer draws; an engine organizes. This phase is about architecture.

- **4.1** Mesh and material classes: geometry as data (vertices, triangles, UVs)
  instead of hardcoded arrays.
- **4.2** Level format: grid-based maps (like Wolfenstein 3D / Doom) defined in plain
  text files — `#` = wall, `.` = floor, `D` = door. A loader turns the file into meshes.
- **4.3** Collision: axis-aligned bounding boxes (AABB) against the grid, sliding along
  walls (why you don't just stop dead).
- **4.4** Entities: a base `Entity` class — position, update, render — and an entity
  list in the world. The player becomes an entity.
- **4.5** Scene structure: separating engine code (`engine/`) from game code (`game/`).
  The engine gets a name and could, in principle, run a different game.
- **4.6** **Milestone:** a dungeon designed in a text file — corridors, rooms, at
  least one door — fully walkable with sliding collision.

---

## Phase 5 — Making it a game

**~5 weeks · Milestone: a complete, winnable 3-level dungeon crawler**

Everything that turns a tech demo into a game. This phase uses the classic Doom trick:
**enemies and items are billboarded sprites** — flat images that always face the camera —
which look great in a retro game and sidestep 3D character modeling entirely.

- **5.1** Billboard sprites: rendering camera-facing quads with transparency, depth-sorted
  against the z-buffer. First enemy appears in the world.
- **5.2** Enemy behavior: states (idle → chase → attack), line-of-sight checks,
  pathing through the grid.
- **5.3** Combat: raycast shooting/melee (reusing our math!), enemy and player health,
  hit feedback, death.
- **5.4** Items and interaction: pickups (health, keys), locked doors, triggers.
- **5.5** HUD and menus: 2D overlay rendering (health bar, crosshair), title screen,
  pause, game over, victory.
- **5.6** Sound: `javax.sound.sampled` — footsteps, combat, ambient dungeon loop.
- **5.7** Levels: design and build 3 levels with escalating difficulty; win condition.
- **5.8** **Milestone:** someone who isn't you plays it start to finish.

---

## Phase 6 — Polish and ship

**~2 weeks · Milestone: a double-clickable game you can send to a friend**

- **6.1** Playtesting round: watch two people play, fix the top confusions.
- **6.2** Performance pass #2: profile, fix the worst frame-time offenders.
- **6.3** Juice: screen shake, hit flashes, better lighting falloff — cheap tricks,
  huge feel.
- **6.4** Packaging: `jpackage` to build a native app (macOS `.app` / Windows `.exe`).
- **6.5** Write the postmortem: what you built, what you learned, what you'd do
  differently. (This is the best interview artifact a self-taught programmer can have.)

---

## Phase 7 — Optional: port the renderer to the GPU (OpenGL / LWJGL)

**~4–6 weeks · Milestone: the same game running on OpenGL at silly frame rates**

**Decision deferred on purpose** — see [DECISIONS.md](DECISIONS.md#d2). After shipping,
if you want to learn modern GPU graphics, we replace `engine/render/` with an
OpenGL backend using LWJGL 3.4.x: vertex buffers, GLSL shaders, the real pipeline.
Because Phase 4 separated engine from game, the game code shouldn't change.
Everything you learned in Phase 3 maps 1:1 onto what the GPU does — you'll recognize
all of it.

---

## Progress tracking

We keep a checkbox list per phase in this file as we go, and the **Status** line in the
README always names the current phase and sub-step.
