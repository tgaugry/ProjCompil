extrn lirent:proc, ecrent:proc
extrn ecrbool:proc
extrn ecrch:proc, ligsuiv:proc
; entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

; ouvrePrinc 6
mov bp,sp
sub sp,6

; iconst 2
push word ptr 2

; istore -2
pop ax
mov word ptr[bp-2], ax

; iconst
; iload -2
push word ptr[bp-2]
; iconst 4
push word ptr 4

; iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0

; ecrireBool
call ecrbool

; iconst 2
push word ptr 2

; iconst
; iload -2
push word ptr[bp-2]
; imul
pop bx
pop ax
imul bx
push ax

; iconst 3
push word ptr 3

; iadd
pop bx
pop ax
add ax,bx
push ax

; iconst
; iconst 3
push word ptr 3

; imul
pop bx
pop ax
imul bx
push ax

; iadd
pop bx
pop ax
add ax,bx
push ax

; queue
nop
EXITCODE
End debut

