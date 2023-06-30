/*
  Based on course material for "Lambdas & Streams in Java 8", a seminar
  prepared and owned by Angelika Langer & Klaus Kreft.
  Used during a conference session entitled "Stream Puzzlers" at the
  JAX 2016 conference in Mainz, Germany.

  ? Copyright 1995-2016 by Angelika Langer & Klaus Kreft. All rights reserved.
  contact: www.AngelikaLanger.com or mailto: info@AngelikaLanger.com

  Permission to use, copy, and modify this software for any non-profit
  purpose is hereby granted to attendants of the above mentioned seminar
  or conference session without fee, provided that the above copyright notice
  appears in all copies.

  Angelika Langer and Klaus Kreft make no representations about the suitability
  of this software for any purpose.  It is provided "as is" without express
  or implied warranty.
 */

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;



public class Main {

	public static void main(String ... argv) {
		//puzzler01();
		puzzler02();
		puzzler02a();
		//puzzler02aa();
		//puzzler02b();
		//puzzler03();
		//puzzler04();
		//puzzler05();
		//puzzler06();
		//puzzler07();
		//puzzler07a();
		//puzzler07b();
		//puzzler08();
	}

	private static String toggle(String in) {
		char[] chars = in.toCharArray();
		char[] buf = new char[chars.length];
		for (int i=0;i<chars.length;i++) {
			if (Character.isLowerCase(chars[i])) buf[i] = Character.toUpperCase(chars[i]);
			if (Character.isUpperCase(chars[i])) buf[i] = Character.toLowerCase(chars[i]);
		}
		return new String(buf);
	}



	private static final String[] chars = {"a", "b", "c", "d", "e", "f", "g", "h"};


	private static void puzzler01() {
		System.out.println("* puzzler01 *");

		Arrays.stream(chars).parallel()
		.forEach(s -> System.out.print(s));

		System.out.println();
	}


	private static void puzzler02() {
		System.out.println("* puzzler02 *");

		String result = Arrays.stream(chars).parallel()
				.reduce("", (s1, s2) -> s1 + s2);

		System.out.println("reduce: " + result);
	}


	private static void puzzler02a() {
		System.out.println("* puzzler02a *");

		String result = Arrays.stream(chars).parallel()
				.reduce("->", (s1, s2) -> s1 + s2);

		System.out.println("reduce: " + result);
	}

	private static void puzzler02aa() {
		System.out.println("* puzzler02aa *");

		String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
				"s", "t", "u", "v", "w", "x", "y", "z"};

		String result = Arrays.stream(alphabet).parallel()
				.reduce("->", (s1, s2) -> s1 + s2);

		System.out.println("reduce: " + result);
	}

	private static void puzzler02b() {
		System.out.println("* puzzler02b *");

		String result = Arrays.stream(chars)
				.reduce("", (s1, s2) -> toggle(s1) + s2);

		System.out.println("reduce sequentially: " + result);

		result = Arrays.stream(chars).parallel()
				.reduce("", (s1, s2) -> toggle(s1) + s2);

		System.out.println("reduce parallel: " + result);
	}

	private static void puzzler03() {
		System.out.println("* puzzler03 *");

		final AtomicInteger ai = new AtomicInteger(1);

		String result = Stream.generate(() -> ai.getAndIncrement()).parallel()
				.limit(16)
				.map(i -> Integer.toString(i.intValue()) + " ")
				.reduce("", (s1, s2) -> s1 + s2);

		System.out.println(result);
	}

	private static void puzzler04() {
		System.out.println("* puzzler04 *");

		String result = Stream.iterate(1, i -> i+1).parallel()
				.limit(16)
				.map(i -> Integer.toString(i.intValue()) + " ")
				.reduce("", (s1, s2) -> s1 + s2);

		System.out.println(result);
	}

	private static void puzzler05() {
		System.out.println("* puzzler05 *");

		String result = Arrays.stream(chars).parallel()
				.map(s -> toggle(s))
				.reduce("", (s1, s2) -> s1 + s2);

		System.out.println("reduce: " + result);
	}

	private static void puzzler06() {
		System.out.println("* puzzler06 *");

		final AtomicInteger ai = new AtomicInteger(1);

		String result = Stream.generate(() -> ai.getAndIncrement()).parallel()
				.sorted()
				.limit(16)
				.map(i -> Integer.toString(i.intValue()) + " ")
				.reduce("", (s1, s2) -> s1 + s2);

		System.out.println(result);
	}


	private static void puzzler07() {
		System.out.println("* puzzler07 *");

		Arrays.stream(chars).parallel()
		.map(s -> toggle(s))
		.forEach(s -> System.out.print(s));

		System.out.println();
	}

	private static void puzzler07a() {
		System.out.println("* puzzler07a *");

		Arrays.stream(chars).parallel()
		.map(s -> toggle(s))
		.sequential()
		.forEach(s -> System.out.print(s));

		System.out.println();
	}

	private static void puzzler07b() {
		System.out.println("* puzzler07b *");

		Arrays.stream(chars).parallel()
		.map(s -> { String retVal = toggle(s);
		System.out.println(Thread.currentThread().getName() + " maps: " + s + " -> " + retVal);
		return retVal;
		})
		.sequential()
		.forEach(s -> System.out.println(s));

		System.out.println();
	}

	private static void puzzler08() {
		System.out.println("* puzzler08 *");

		Arrays.stream(chars).parallel()
		.map(s -> { String retVal = toggle(s);
		System.out.println(Thread.currentThread().getName() + " maps: " + s + " -> " + retVal);
		return retVal;
		})
		.forEachOrdered(s -> System.out.println(s));

		System.out.println();
	}



}
