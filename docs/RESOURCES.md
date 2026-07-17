# Learning resources

Curated per phase. Rule of thumb: **build first, read second** — these are for going
deeper on something we've already touched, or for a second explanation when mine doesn't
click. You never need to finish a resource; take what you need.

## Phase 0 — Java fundamentals

- [Dev.java Learn](https://dev.java/learn/) — Oracle's official, modern Java tutorial track. Our primary reference.
- [Java documentation (API docs)](https://docs.oracle.com/en/java/javase/21/docs/api/) — learn to read these early; it's a superpower.
- [Pro Git, chapters 1–3](https://git-scm.com/book/en/v2) — free book; the first three chapters are all we need.

## Phase 1 — Game loops and pixels

- [Game Programming Patterns — Game Loop](https://gameprogrammingpatterns.com/game-loop.html) — free online book chapter; the clearest game-loop explanation anywhere.
- [Fix Your Timestep! (Gaffer on Games)](https://gafferongames.com/post/fix_your_timestep/) — the classic article on timing; read after building our loop.

## Phases 2–3 — 3D math and the software renderer

These are the canon for what we're building:

- [Computer Graphics from Scratch — Gabriel Gambetta](https://gabrielgambetta.com/computer-graphics-from-scratch/) — free online book; builds a rasterizer with no libraries, exactly our approach. **Primary companion for Phases 2–3.**
- [Scratchapixel](https://www.scratchapixel.com/) — deep, free explanations of every graphics concept (projection, rasterization, texturing). Reference, not tutorial.
- [tinyrenderer](https://github.com/ssloy/tinyrenderer) — famous "build OpenGL yourself in 500 lines" course (C++, but the ideas transfer 1:1).
- [Triangle rasterization in practice — Fabian Giesen](https://fgiesen.wordpress.com/2013/02/08/triangle-rasterization-in-practice/) — how real rasterizers fill triangles; read during 3.1.
- [Essence of Linear Algebra — 3Blue1Brown (YouTube)](https://www.youtube.com/playlist?list=PLZHQObOWTQDPD3MizzM2xVFitgF8CeVfR) — visual intuition for vectors and matrices; watch alongside 2.1–2.4.

## Phases 4–5 — Engine architecture and game feel

- [Game Programming Patterns (full book)](https://gameprogrammingpatterns.com/) — component, state, and update patterns; dip in as topics arise (5.2 especially).
- [Game Engine Black Book: DOOM — Fabien Sanglard](https://fabiensanglard.net/gebbdoom/) — how Doom actually worked; incredibly motivating once you've built the same pieces.
- [Wolfenstein 3D's map format & raycasting write-ups (Fabien Sanglard)](https://fabiensanglard.net/gebbwolf3d/) — grid-based level design, our Phase 4 model.

## Phase 7 (optional) — OpenGL / LWJGL

- [LWJGL 3](https://www.lwjgl.org/) — current stable is 3.4.1 (Feb 2026); has a getting-started guide and Maven/Gradle config generator.
- [LearnOpenGL](https://learnopengl.com/) — the standard OpenGL course (C++, transfers well once you know the concepts).
- [3D Game Development with LWJGL 3 (free book)](https://ahbejarano.gitbook.io/lwjglgamedev/) — Java-specific LWJGL walkthrough.

## When stuck

1. Reproduce the problem in the smallest possible program.
2. Read the error message out loud, top line first.
3. Ask Claude — but bring your theory of what's wrong, even a bad one. (That's a rule:
   it's how debugging skill forms.)
