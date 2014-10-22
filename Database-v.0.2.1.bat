	TITLE "mp3.aTITLE	"mp4.a -- by Douglas Jones"
	; plots a centered square Sierpinski gasket
	; on the screen, the largest that will fit.

	; this version of the code is optimized to reduce
	; twiddling of R2 before and after each call.

	USE	"hawk.h"
	USE	"monitor.h"

	S	MAIN	; the main program is at the end
	INT	MAIN

	SUBTITLE "GASKET -- recursive plot routine"
;RETAD	=	0
X	=	4	; gasket coordinates
Y	=	8
ORD	=	12	; gasket order
DISP	=	16	; displacement between sub gaskets of this gasket
ARSIZE	=	20

GASKET:	; expects R3 = x -- coordinates of gasket center
	;	  R4 = y 
	;	  R5 = ord -- the order of the gasket
	STORES	R1,R2
	ADDI	R2,R2,ARSIZE

	TESTR	R5
	BZR	GASELS		; if (ord != 0) { /* basis case, order zero */

	ADDSI	R3,-1		;   -- parameter
	LIL	R1,PUTAT
	JSRS	R1,R1		;   putat( x-1 , y )

	LIS	R3,'['		;   -- parameter
	LIL	R1,PUTCHAR
	JSRS	R1,R1		;   putchar( '[' )

	LIS	R3,']'		;   -- parameter
	LIL	R1,PUTCHAR
	JSRS	R1,R1		;   putchar( ']' )

	BR	GASEND
GASELS: 			; } else { /* recursive case */
	STORE	R3,R2,X-ARSIZE	;   -- save variables to survive recursion
	STORE	R4,R2,Y-ARSIZE
	ADDSI	R5,-1		;   ord = ord - 1
	STORE	R5,R2,ORD-ARSIZE
				;   -- first, find out how big this gasket is
	ADDSI   R5,1		;   o = ord + 1 -- using R5 for now
	LIS	R6,1		;   disp = 1
GASLP:				;   do { -- should be pre-test loop, not post
	ADDSI	R5,-1		;     o = o - 1
	BLE	GASLPQ		;     if (o <= 0) break
	ADDSL	R6,R6,1		;     disp = disp * 3
	BR	GASLP
GASLPQ:				;   }
	STORE	R6,R2,DISP-ARSIZE;  -- disp is displacement between sub gaskets

				;   -- second, plot 8 sub-gaskets
	MOVESL	R7,R6,1
	SUB	R3,R3,R7	;   -- parameter x - (disp << 1)
	SUB	R4,R4,R6	;   -- parameter y - disp
	LOAD	R5,R2,ORD-ARSIZE;   -- parameter ord
	JSR	R1,GASKET	;   gasket(x-(disp << 1),y-disp, ord)

	LOAD	R3,R2,X-ARSIZE
	LOAD	R6,R2,DISP-ARSIZE
	MOVESL	R7,R6,1
	ADD	R3,R3,R7	;   -- parameter x + (disp << 1)
	LOAD	R4,R2,Y-ARSIZE
	ADD	R4,R4,R6	;   -- parameter y + disp
	LOAD	R5,R2,ORD-ARSIZE;   -- parameter ord
	JSR	R1,GASKET	;   gasket(x+(disp<<1),y+ disp, ord );

	LOAD	R3,R2,X-ARSIZE
	LOAD	R6,R2,DISP-ARSIZE
	MOVESL	R7,R6,1
	ADD	R3,R3,R7	;   -- parameter x + (disp << 1)
	LOAD	R4,R2,Y-ARSIZE
	SUB	R4,R4,R6	;   -- parameter y - disp
	LOAD	R5,R2,ORD-ARSIZE;   -- parameter ord
	JSR	R1,GASKET	;   gasket( x + (disp << 1), y - disp, ord );

	LOAD	R3,R2,X-ARSIZE	;   -- parameter x
	LOAD	R4,R2,Y-ARSIZE
	LOAD	R6,R2,DISP-ARSIZE
	SUB	R4,R4,R6	;   -- parameter y - disp
	LOAD	R5,R2,ORD-ARSIZE;   -- parameter ord
	JSR	R1,GASKET	;   gasket( x              , y - disp, ord );

	LOAD	R3,R2,X-ARSIZE	;   -- parameter x
	LOAD	R4,R2,Y-ARSIZE
	LOAD	R6,R2,DISP-ARSIZE
	ADD	R4,R4,R6	;   -- parameter y + disp
	LOAD	R5,R2,ORD-ARSIZE;   -- parameter ord
	JSR	R1,GASKET	;   gasket( x              , y + disp, ord );

	LOAD	R3,R2,X-ARSIZE
	LOAD	R6,R2,DISP-ARSIZE
	MOVESL	R7,R6,1
	SUB	R3,R3,R7	;   -- parameter x - (disp << 1)
	LOAD	R4,R2,Y-ARSIZE	;   -- parameter y
	LOAD	R5,R2,ORD-ARSIZE;   -- parameter ord
	JSR	R1,GASKET	;   gasket( x - (disp << 1), y       , ord );

	LOAD	R3,R2,X-ARSIZE
	LOAD	R6,R2,DISP-ARSIZE
	MOVESL	R7,R6,1
	ADD	R3,R3,R7	;   -- parameter x + (disp << 1)
	LOAD	R4,R2,Y-ARSIZE	;   -- parameter y
	LOAD	R5,R2,ORD-ARSIZE;   -- parameter ord
	JSR	R1,GASKET	;   gasket( x + (disp << 1), y       , ord );

	LOAD	R3,R2,X-ARSIZE
	LOAD	R6,R2,DISP-ARSIZE
	MOVESL	R7,R6,1
	SUB	R3,R3,R7	;   -- parameter x - (disp << 1)
	LOAD	R4,R2,Y-ARSIZE
	ADD	R4,R4,R6	;   -- parameter y + disp
	LOAD	R5,R2,ORD-ARSIZE;   -- parameter ord
	JSR	R1,GASKET	;   gasket( x - (disp << 1), y + disp, ord );

GASEND:				; }
	ADDI	R2,R2,-ARSIZE
	LOADS	R1,R2
	JUMPS	R1		; return

	SUBTITLE "MAIN -- main program"

;RETAD	= 	0
ARSIZE	=	4

MAIN:	; expects R3 = screen width
	;	  R4 = screen height
	STORES	R1,R2
	ADDI	R2,R2,ARSIZE
				; -- first, find the narrowest dimension
	MOVE	R6,R3
	SR	R6,1		; d = width / 2
	CMP	R6,R4
	BLE	MAINDF		; if (d > height) {
	MOVE	R6,R4		;   d = height
MAINDF:				; }

				; -- second, what order fits on the screen
	LIS	R5,0		; ord = 0
	LIS	R7,1		; size = 1  -- order 0 gasket is size 1
MAINLP:
	CMP	R7,R6
	BGT	MAINLQ		; while (size <= d) {
	ADDSI	R5,1		;   ord = ord + 1;
	ADDSL	R7,R7,1		;   size = size * 3;
	BR	MAINLP
MAINLQ:				; }
	ADDSI	R5,-1		; ord = ord - 1  -- because we overshot

				; -- third, plot a gasket centered on the screen
	SR	R3,1		; -- parameter width / 2
	SR	R4,1		; -- parameter height / 2
	JSR	R1,GASKET	; gasket( width / 2, height / 2, ord );

	ADDI	R2,R2,-ARSIZE
	LOADS	R1,R2
	JUMPS	R1		; return

	END
