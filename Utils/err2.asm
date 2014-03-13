; entete
.model SMALL
.586
.CODE
debut:
STARTUPCODE

; ouvrePrinc6
mov bp,sp
sub sp,6

push 2
; istore
pop ax
mov word ptr[bp-2],ax

; iconst
push word ptr[bp-2]
push 4
; iinfegal
pop bx
pop ax
cmp ax,bx
jg $+6
push -1
jmp $+4
push 0

ecrireBool
push 2
; iconst
push word ptr[bp-2]
; imul
pop bx
pop ax
imul bx
push ax

push 3
; iadd
pop bx
pop ax
add ax,bx
push ax

; iconst
push 3
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
exitcode
end debut

